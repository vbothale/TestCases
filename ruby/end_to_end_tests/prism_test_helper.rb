ENV['HEADLESS'] ||= "true"

require 'watir'
require 'yaml'
require 'rubygems'
require 'fileutils'
require 'rbconfig'
require 'headless'
gem 'minitest'
require 'minitest/autorun'
require 'minitest/reporters'
Minitest::Reporters.use! Minitest::Reporters::SpecReporter.new(:color => true)

######### Watir Helper #########
module OpenBrowser  
  ENV['BROWSER_TYPE'] ||= 'ff'    ;#Other possible type: 'firefox' ; 'ie' ; 'chrome'
  attr_accessor :browser, :headless, :profile
  
  def open_browser(browser_type = ENV['BROWSER_TYPE'])
    load_yml_as_hash
    if defined?(profile) && (profile.has_key? :browser_type)      
      browser_type = profile[:browser_type]
    end 
    # headless
    if ENV['HEADLESS'] == "true" && RbConfig::CONFIG['host_os'] =~ /linux/
      @headless = Headless.new 
      headless.start
    end
    # browser_type
    if browser_type == 'ff' || browser_type == 'firefox'
      ENV["WATIR_DRIVER"] = "webdriver"
      require 'watir-webdriver'
      @browser = Watir::Browser.new(:ff)
    elsif browser_type == 'ie'
      ENV["WATIR_DRIVER"] = "classic" #to ensure that watir-classic is used instead of webdriver-IE driver
      @browser = Watir::Browser.new(:ie)
    elsif browser_type == 'chrome'
      ENV["WATIR_DRIVER"] = "webdriver"
      require 'watir-webdriver'
      @browser = Watir::Browser.new(:chrome)
    end
    
    return browser
  end
  
  def close_all_windows
    #puts "===Closing browser session==="
    browser.windows.each do |window|
      window.use
      browser.execute_script("window.onbeforeunload = null")
      browser.execute_script("window.onbeforeunload = function() {};")
      sleep 1
      window.close rescue nil
    end
    begin ; browser.alert.ok if browser.alert.exists? ; rescue; end    
    #headless
    headless.destroy if ENV['HEADLESS'] == "true" && RbConfig::CONFIG['host_os'] =~ /linux/
  end
  
  def load_yml_as_hash
    ##looks at current dir and for ENV['YML_FILE'] if it exists, then it will use ENV['YML_DEFAULT_ENTITY']
    ENV['YML_DEFAULT_ENTITY'] ||= 'default'  
    ENV['YML_FILE'] ||= 'profiles.yml'
        
    prof_path = File.expand_path(File.dirname(__FILE__) + "/#{ENV['YML_FILE']}")
    if File.exists? prof_path 
      @profile = YAML.load_file(prof_path)["#{ENV['YML_DEFAULT_ENTITY']}"]    
    else 
      @profile = {:browser_type => ENV['BROWSER_TYPE']}
    end    
  end

end
include OpenBrowser

