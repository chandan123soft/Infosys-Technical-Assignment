Feature: A calculator to get a quick estimate on how much you may be able to borrow based on your 
current income and existing financial commitments

Scenario: Enter Your details,earnings and expense
When Applicatin Type is Single 
And Enter Number of dependants
And Click on Home to live in
And Enter the annual income
And Enter the other income
And Enter the Monthly living expenses
And Enter the Current home loan monthly repayments
And Enter the Other loan monthly repayments 
And Enter the Other monthly commitments 
And Enter the Total credit card limits
And Click the button Work out how much I could borrow

Scenario: The start over button is click then clears the form
When First click the start over button
Then Clears the form details

Scenario: Based on the details you have entered the form
When Enter only $1 for Living expenses
Then Click the button Work out how much I could borrow and validate the message