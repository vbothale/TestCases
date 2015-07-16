################################## 
######### Prism Helper #########
module PrismHelper

  def login_to_prism
    if defined?(profile) && (profile.has_key? :url)
      browser.goto(profile[:url])
      browser.text_field(:id => /j_username/).set profile[:login]
      browser.text_field(:id => /j_password/).set profile[:password]
    else
      browser.goto('http://qa.provapps.com/ProvAppCLWeb/')
      browser.text_field(:id => /j_username/).set 'fmartin'
      browser.text_field(:id => /j_password/).set 'Provenir1'
    end

    browser.button(:text => /Login/).click
    browser.button(:text => /Login/).wait_while_present
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
  end
  
  def initiate_new_credit_request
    Watir::Wait.until { browser.div(:class => /left_nav/).link(:id => /newCredRequest/).present? }
    browser.div(:class => /left_nav/).link(:id => /newCredRequest/).focus
    3.times { browser.div(:class => /left_nav/).send_keys :arrow_down }
    browser.div(:class => /left_nav/).link(:id => /newCredRequest/).fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
  end
  
  def create_new_credit_request
    Watir::Wait.until { browser.text_field(:id => /creditNm/).present? }
    timenow = Time.now.strftime('%m%d_%H%M')
    credit_name = "Credit Auto #{timenow}"
    
    browser.text_field(:id => /creditNm/).set credit_name
    browser.text_field(:name => /creditAppliDt/).set Time.now.strftime('%Y-%m-%d')
    browser.text_field(:name => /creditAgreeDt/).set Time.now.strftime('%Y-%m-%d')
    browser.text_field(:name => /creditProjClsDt/).set (Time.now+(365*24*3600)).strftime('%Y-%m-%d')
    browser.text_field(:name => /creditProjClsDt/).parent.click
    browser.link(:id => /savecreddetails/).fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
  end
  
  def add_new_customer_to_list
    Watir::Wait.until { browser.link(:name => /addParty/).present? }
    browser.link(:name => /addParty/).when_present.fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
  end
  
  def input_new_customer_info        
    timenow = Time.now.strftime('%m%d_%H%M')
    comp_legal_name = "Comp Auto #{timenow}"
    comp_short_name = "Comp Auto #{timenow}"
    
    browser.div(:id => 'wizardCustDetailsDiv').wait_until_present
    browser.select_list(:id => 'custTypeId').select 'Business'
    browser.text_field(:id => /compLglName/).set comp_legal_name
    browser.text_field(:id => /compShortName/).set comp_short_name
    browser.text_field(:name => /customerSince/).set Time.now.strftime('%Y-%m-%d')
    browser.text_field(:name => /customerSince/).parent.click
    browser.label(:text => /Customer Since/).click
    browser.text_field(:id => /tin/).set '54321'
    label_combobox('Corporate Structure','Association')
    label_combobox('Branch','Parsippany')
    label_combobox('Expense Code','-Main Cost Center')
    label_combobox('Department','Mid Market')
    browser.text_field(:id => /garSourceDT/).set Time.now.strftime('%Y-%m-%d')
    browser.text_field(:id => /lastTaxReturn/).set Time.now.strftime('%Y-%m-%d')
    browser.text_field(:id => /annRevwDt/).set Time.now.strftime('%Y-%m-%d')
    browser.text_field(:name => /interimRevwDt/).set Time.now.strftime('%Y-%m-%d')
    browser.text_field(:name => /interimRevwDt/).parent.click
    label_combobox('Customer Classification Code', '-Medium Business')
    browser.text_field(:name => /fiscalYrEnd/).set 'Jun'
    label_combobox('NAICS Code', '-Rice Farming')
    label_combobox('SIC Code', '-Metal Mining')
    label_combobox('Legal Code', '-No Legal Issues')
    browser.text_field(:name => /dUNSNumber/).set 2
    browser.link(:id => /savecustdetails/).fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    sleep 2
    browser.link(:id => /useCurrentCust/).when_present.focus
    browser.link(:id => /useCurrentCust/).when_present.fire_event('onclick')
    Watir::Wait.until { browser.td(:text => /#{comp_legal_name}/).present? rescue nil }
  end
  
  def go_to_next_step
    browser.link(:id => /nextBtn/).when_present.fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
  end
  
  def add_new_collateral_to_pool
    browser.link(:id => /addCollPool/).fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
  end
  
  def input_new_collateral_info
    timenow = Time.now.strftime('%m%d_%H%M')
    coll_name = "Coll Auto #{timenow}"
    
    browser.div(:id => /collateralDetails/).wait_until_present
    browser.text_field(:id => /collAccName/).when_present.set coll_name
    #label_combobox('Collateral Type', 'Vehicles')
    select_list_combobox('collType', 'Vehicles')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    sleep 2    ;#hardcoded to load proper subtype
    browser.select_list(:id => /collSubType/).select 'Other Vehicles'
    sleep 2
    
    browser.select_list(:id => 'locMovable').when_present.select 'Yes'
    browser.select_list(:id => 'country').select 'United States'
    browser.text_field(:id => /city/).when_present.set 'Parsippany'
    browser.text_field(:id => /addr1/).set '300'
    browser.text_field(:id => /addr2/).set 'Interpace Pkwy'
    browser.text_field(:id => /zip/).set '07054'
    sleep 1
  end
  
  def select_collateral_owners
    ## Collateral Owners
    customer_name = 'aaaaa'
    customer_number = 'CUST000000000001599'
    
    browser.div(:id => /ownersList/).text_fields[0].when_present.set customer_name
    browser.div(:id => /ownersList/).text_fields[0].parent.link(:id => /ownSearch/).click
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    browser.div(:id => 'openPopup').td(:text => /#{customer_number}/).wait_until_present
    browser.div(:id => 'openPopup').td(:text => /#{customer_number}/).parent.radio.when_present.fire_event('onclick')
    sleep 1
    browser.span(:text => /Load/).fire_event('onclick')
    browser.label(:text => /#{customer_number}/).wait_until_present
    browser.text_field(:id => /ownerPer/).when_present.set 100
    browser.radio(:id => 'selectPrimaryOwner').set
    browser.link(:id => /saveCollPoolDetails/).when_present.fire_event('onclick')
    browser.div(:class => /sub_content_div_alternate/).wait_until_present(90) rescue nil
  end
  
  def add_new_transaction_to_list
    browser.link(:id => /addTrans/).fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(90)
  end
  
  def input_new_transaction_info
    timenow = Time.now.strftime('%m%d_%H%M')
    fac_name = "Facility Auto #{timenow}"
    fac_type = 'Line of Credit'
    req_amount = '100000'
    
    browser.text_field(:id => 'crdLnName').when_present.set fac_name 
    label_combobox('Facility Type',fac_type)

    select_list_combobox('crdCurr','USD')
    browser.text_field(:id => 'crdPropAmt').set req_amount
    browser.text_field(:id => 'crdCurProjAmt').set '456'
    browser.text_field(:id => 'crdClsAmt').set '789'

    select_list_combobox('bnkCurr','USD')
    browser.text_field(:id => 'bnkPropAmt').set '987'
    browser.text_field(:id => 'bnkCurProjAmt').set '654'
    browser.text_field(:id => 'bnkClsAmt').set '321'
    
    browser.link(:id => /saveCredLnSummDetails/).focus
    browser.link(:id => /saveCredLnSummDetails/).fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
  end
  
  def choose_product_offering
    offering = '30 yr 10yrs fixed'
    
    browser.link(:id => 'prodCatlogBtn').focus
    browser.link(:id => 'prodCatlogBtn').when_present.fire_event('onclick')
    browser.div(:id => 'openPopup').td(:text => offering).wait_until_present
    browser.div(:id => 'openPopup').td(:text => offering).parent.checkbox.when_present.set
    browser.span(:text => /Load/).fire_event('onclick')
    browser.span(:text => /Load/).wait_while_present
  end
  
  def select_ugr
    role='Relationship Manager'
    
	browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil	
    
	unless browser.label(:text => /Attribute Names/).parent.select_list.selected? 'L Function'
      browser.label(:text => /Attribute Names/).parent.select_list.select 'L Function'
      browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil	  
	  browser.div(:id => 'openPopup').link(:text => /Ok/).when_present.fire_event('onclick')
	  browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil	
	  multi_select = browser.label(:text => /Attribute Values/).parent.select_list.clear
	  browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil	
	  multi_select = browser.label(:text => /Attribute Values/).parent.select_list.options.count
	  (multi_select-1).times do |i|
	    browser.label(:text => /Attribute Values/).parent.select_list.options[i+1].click
		browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil	
	  end
	  browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil		  
	end
	
	#browser.link(:id => 'addNewCredTeam').focus
    #browser.link(:id => 'addNewCredTeam').when_present.fire_event('onclick')
    #browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    	
    browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].wait_until_present
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].when_present.select role	
	
    browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.text_fields[0].when_present.set 'Frank'
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    Watir::Wait.until { browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.lis.count >= 1 }
    browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.lis[0].when_present.fire_event('onclick')
	Watir::Wait.while { browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.lis.count >= 1 }
	browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    
    browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.text_fields[1].when_present.set 'Abby'
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    Watir::Wait.until { browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.lis.count >= 1 }
    browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.lis[0].when_present.fire_event('onclick')
	Watir::Wait.while { browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.lis.count >= 1 }
	browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    
    browser.table(:class => 'tableGrid').select_lists(:name => /roleCd/)[-1].parent.parent.checkbox.set
    
    browser.link(:id => 'savecreddetails').focus
    browser.link(:id => 'savecreddetails').fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
  end
  
  def submit_request
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    browser.link(:id => 'finishDataEntry').focus
    browser.link(:id => 'finishDataEntry').when_present.fire_event('onclick')
    begin
      browser.image(:src => /loader.gif/).wait_while_present(300) 
    rescue => e
      puts e
    end
  end
  
  def assert_e2e_ncr
    Watir::Wait.until { browser.div(:class => /popupContent/).present? }
	## Assert in 'confirmatino popup'
    assert browser.div(:class => /popupContent/).text.include? 'Thank you for your application submission'
    assert browser.div(:class => /popupContent/).text.include? 'Comp Auto'
    browser.div(:class => /popupContent/).link(:id => 'mydashBoard').when_present.fire_event('onclick')
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
	
	## Assert in 'My Dashboard'
    Watir::Wait.until { browser.div(:class => 'dashboard_heading', :text => /My Dashboard/).present? }
	browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    assert browser.div(:id => 'myDashBoard').table[2].link(:id => 'custLnk').when_present.text.include? 'Comp Auto'
    assert browser.div(:id => 'myDashBoard').table[2].link(:id => 'credLnk').text.include? 'Credit Auto'
    assert browser.div(:id => 'myDashBoard').table[2].link(:id => 'credLineLnk').text.include? 'Facility'
    assert browser.div(:id => 'myDashBoard').table[2].text.include? 'Line of Credit'
    assert browser.div(:id => 'myDashBoard').table[2].text.include? Time.now.strftime('%Y-%m-%d')
  end
  

end
include PrismHelper





################################## 
#### Page Locator Helper ####
module ElementLocatorHelper

  def label_combobox (label_name, text_pattern)
    browser.label(:text => /#{label_name}/).parent.text_field.when_present.focus
    1.times { browser.div(:class => /DataInner/).send_keys :arrow_down } 
    browser.label(:text => /#{label_name}/).parent.text_field.when_present.set text_pattern
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    sleep 1
    browser.label(:text => /#{label_name}/).parent.text_field.send_keys :arrow_down 
    browser.label(:text => /#{label_name}/).parent.text_field.send_keys :enter
    sleep 1
  end
  
  def select_list_combobox(select_list_id, text_pattern)
    browser.select_list(:id => select_list_id).parent.text_field.when_present.focus
    1.times { browser.div(:class => /DataInner/).send_keys :arrow_down } 
    browser.select_list(:id => select_list_id).parent.text_field.when_present.set text_pattern
    browser.image(:src => /loader.gif/).wait_while_present(60) rescue nil
    sleep 1
    browser.select_list(:id => select_list_id).parent.text_field.send_keys :arrow_down
    browser.select_list(:id => select_list_id).parent.text_field.send_keys :enter
  end
end
include ElementLocatorHelper