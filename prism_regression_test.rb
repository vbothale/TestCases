require File.expand_path(File.dirname(__FILE__) + '/prism_test_helper.rb')
require File.expand_path(File.dirname(__FILE__) + '/prism_helper.rb')

class PrismRegressionTest < MiniTest::Test
  def setup
    open_browser
    login_to_prism
  end
  
  def teardown
    #close_all_windows
  end

  
  ####################### TEST SUITE #######################  
  def test_e2e_ncr
    initiate_new_credit_request
    ## step 1: Request Summary
    create_new_credit_request
    ## step 2: Customer Info
    add_new_customer_to_list
    input_new_customer_info
    go_to_next_step
    ## step 3: Collateral Info
    add_new_collateral_to_pool
    input_new_collateral_info
    select_collateral_owners
    go_to_next_step
    ## step 4: Transaction Info
    add_new_transaction_to_list
    input_new_transaction_info
    choose_product_offering
    go_to_next_step
    ## step 5: User Team Information
    select_ugr
    submit_request
    ## Assert section (criterias that the test is successful)
    assert_e2e_ncr
  end
  
end



