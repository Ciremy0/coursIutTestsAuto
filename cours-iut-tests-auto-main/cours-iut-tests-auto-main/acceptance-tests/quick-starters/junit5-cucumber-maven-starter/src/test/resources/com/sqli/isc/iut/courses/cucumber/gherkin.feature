Feature: Le Juste bar

    Background: 
        Given Mr Pignon et Mr Leblanc go to Le Juste bar
        And they are a group of 2 persons
        And the bar have only 10 available places

    Scenario: First story
        Given one available place in the bar
        When they ask to enter in the bar
        Then they are not accepted in the bar

    Scenario: Second story
        Given two available places in the bar
        When they enter into the bar
        Then the bar shows full
        And the person behind them cannot enter in the bar
        And each order one cocktail of the month for 10$
        And Mr Leblanc pays the receipt
        And after drinking their cocktails, they check the receipt and Mr Leblanc pays
        And Mr Pignon is happy because he drank only one drink (liver problem)

    Scenario: Third story   
        Given 3 persons are in the bar
        And they each order a cocktail of the month costing 10$
        And each pays their own drink
        When they finish there cocktail, each person check they receipt
        And Mr Pignon pays but Mr Leblanc insists to order one more drink if the month
        And he orders 2 more drinks of the month to his bill
        And when they finished their drinks, Mr Leblanc check his receipt and pays
        Then Mr Pignon is sad because he knows that he will spend a bad night (liver problem)
        
        
        
        
        