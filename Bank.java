/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Khaled Ashraf Hanafy
 * @author Ahmed Sayed Hassan
 * @author Shimaa Reda Saeed
 * @since  28/4/2021
 * @version 1.0
 */
public class Bank
{
    Scanner input=new Scanner(System.in);
    private String name, address, phone;
    char Option;
    int AccountNumber,NumberOfObject=0;
    double Balance=0.0,withdraw,deposit;
    Account ObjAccount;

    /**
     * Parametrized Constructor To Setts name , address , phone
     * @param name Client name
     * @param address Client address
     * @param phone Client Phone
     */

    Bank(String name,String address,String phone)
    {
        this.name=name;
        this.address=address;
        this.phone=phone;
    }

    /**
     * set Phone From User
     * @param phone Stet Client Phone
     */

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * set Name From User
     * @param name Set Client Name
     */

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * set Address From User
     * @param address Set Client address
     */

    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Return Phone From User
     * @return string Client Phone
     */

    public String getPhone()
    {
        return phone;
    }

    /**
     * Return Name From User
     * @return String Client Name
     */

    public String getName()
    {
        return name;
    }

    /**
     * Return Address From User
     * @return String Client Address
     */

    public String getAddress()
    {
        return address;
    }

    ArrayList<Account> accountsData=new ArrayList<Account>();//Object accountData From ArrayList
    ArrayList<Client> clientsData= new ArrayList<Client>();//Object clientData From ArrayList

    /**
     * add New Client To ArrayList
     * @param Client information Client
     * @param Account information Account Client
     */

    public void addClient(Client Client,Account Account)
    {
        clientsData.add(Client);
        accountsData.add(Account);
    }

    /**
     *Remove Specify Account From ArrayList
     */
    public void Remove()
    {
        int id;
        System.out.print("Enter ID OF Account : ");
        id=input.nextInt();
        if(id <= NumberOfObject && id!=0)
        {
            clientsData.remove(id-1);
            accountsData.remove(id-1);
        }
        else
        {
            System.out.println("ID Not Found");
            Remove();
        }
    }

    /**
     *Display All Client and its Accounts From ArrayList
     */
    public void display()
    {
        for(int i=0;i< accountsData.size();i++)
        {
            System.out.println(clientsData.get(i));
            System.out.println(accountsData.get(i));
            System.out.println();
        }
    }

    /**
     * Menu Accounts To Choose Specify Option From The Program
     */
    public void MenuAccounts()
    {
        System.out.println("withdraw(1) or deposit(2) Or Both(3)");
        Option=input.next().charAt(0);
        if (Option == '1')
        {
            System.out.println("Enter Your withdraw");
            withdraw = input.nextDouble();
            ObjAccount.withdraw(withdraw);
        }
        else if (Option == '2')
        {
            System.out.println("Enter Your deposit");
            deposit = input.nextDouble();
            ObjAccount.deposit(deposit);
        }
        else if (Option == '3')
        {
            System.out.println("Enter Your withdraw");
            withdraw = input.nextDouble();
            ObjAccount.withdraw(withdraw);
            System.out.println("Enter Your deposit");
            deposit = input.nextDouble();
            ObjAccount.deposit(deposit);
        }
        else
        {
            System.out.println("Invalid Number");
            MenuAccounts();
        }
    }

    /**
     * Information AccountS From ArrayList
     * @return Account
     */
    public Account newAccount()
    {
        ObjAccount=new SpecialAccount();
        Random ObjRandom=new Random();
        AccountNumber=(1000000000)+ObjRandom.nextInt(1000000000);
        ObjAccount.SetNumberOFAccount(AccountNumber);
        ObjAccount.SetBalance(Balance);
        MenuAccounts();
        return ObjAccount;
    }

    /**
     * Searching Specify Client From ID and Modify It By Withdraw , deposit
     */
    public void Search()
    {
        int id;
        System.out.print("Enter ID OF Account : ");
        id=input.nextInt();
        if(id<=NumberOfObject && id!=0)
          {
            System.out.println(clientsData.get(id-1));
            System.out.println(accountsData.get(id-1));
            System.out.println("withdraw(1) or deposit(2) Or Both(3)");
            Option=input.next().charAt(0);
            if (Option == '1')
            {
                System.out.println("Enter Your withdraw");
                withdraw = input.nextDouble();
                accountsData.get(id-1).withdraw(withdraw);
            }
            else if (Option == '2')
            {
                System.out.println("Enter Your deposit");
                deposit = input.nextDouble();
                accountsData.get(id-1).deposit(deposit);
            }
            else if (Option == '3')
            {
                System.out.println("Enter Your withdraw");
                withdraw = input.nextDouble();
                accountsData.get(id-1).withdraw(withdraw);
                System.out.println("Enter Your deposit");
                deposit = input.nextDouble();
                accountsData.get(id-1).deposit(deposit);
            }
            else
            {
                System.out.println("Invalid Number");
                Search();
            }
          }
          else
          {
              System.out.println("ID Not Fount");
              Search();
          }
    }


    /**
     * displaying All Options From Current System
     */
    public void displayMenu()
    {
       char choice;
       while(true)
       {
            System.out.println("1-Add Client and Account");
            System.out.println("2-Modify Account for Specify Client");
            System.out.println("3-List of Clients and these Accounts");
            System.out.println("4-Remove Client and these Account");
            System.out.println("5-Exit");
            choice = input.next().charAt(0);
            switch (choice)
            {
                case '1'://To Add New Client Or CommercialClient and its Information
                    {
                        char Option;
                        String name, address, phone;
                        long commercialID,nationalID;
                        System.out.println("client(1) or CommercialClient(2)");
                        Option = input.next().charAt(0);
                        Client ObjectClient;
                        if (Option == '1')
                         {
                            NumberOfObject++;
                            ObjectClient = new Client();
                            System.out.println("Enter separately name,address,phone and nationalID");
                            name = input.next();
                            address = input.next();
                            phone = input.next();
                            nationalID = input.nextLong();
                            ObjectClient.setAddress(address);
                            ObjectClient.setName(name);
                            ObjectClient.setNationalID(nationalID);
                            ObjectClient.setPhone(phone);
                            addClient(ObjectClient, newAccount());
                         }
                         else if (Option == '2')
                         {
                            NumberOfObject++;
                            CommercialClient ObjCommercialClient = new CommercialClient();
                            System.out.println("Enter separately name,address,phone and commercialID");
                            name = input.next();
                            address = input.next();
                            phone = input.next();
                            commercialID = input.nextLong();
                            ObjCommercialClient.setName(name);
                            ObjCommercialClient.setAddress(address);
                            ObjCommercialClient.setPhone(phone);
                            ObjCommercialClient.setCommercialID(commercialID);
                            addClient(ObjCommercialClient, newAccount());
                         }
                         else
                         {
                            System.out.println("Invalid Number, Try again!");
                         }
                         break;
                    }
                case '2'://To Search And Modify
                    {
                        if(NumberOfObject==0)
                        {
                            System.out.println("Not Found Any Account To Modify");
                        }
                        else
                        {
                            Search();
                        }
                        break;
                    }
                case '3'://To display All Users And its Account in System
                    {
                        if(NumberOfObject==0)
                        {
                            System.out.println("Not Found Any Account");
                        }
                        else
                        {
                            display();
                        }
                         break;
                    }
                case '4': //To Remove
                    {
                        if(NumberOfObject==0)
                        {
                            System.out.println("Not Found Any Account To Remove");
                        }
                        else
                        {
                            Remove();
                            NumberOfObject--;
                        }
                        break;
                    }
                case '5':
                    {
                        System.out.println("Program Finished");
                        System.exit(0);//Exit Program
                    }
                default:
                    {
                        System.out.println("Invalid Number, Try Again!");
                        break;
                    }
            }
       }
    }
}