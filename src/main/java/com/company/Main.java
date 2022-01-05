package com.company;

import com.company.constant.Constant;
import com.company.entity.Employee;
import com.company.exception.EmployeeException;
import com.company.exception.PaySlipException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        logger.info("Start generate payslip application");
        System.out.println("Generate payslip application starts, please type command,");

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        String input = "";
        while(in.hasNext()
                && !"*".equals(input)){
            input = in.nextLine();
            if(input==null||input.length()==0){
                System.out.println(Constant.INPUT_NOT_EMPTY);
            }else{
                List<String> params = new ArrayList<>();
                boolean quoted = false;
                for(String q : input.split("\"")) {
                    if(quoted)

                        params.add(q.trim());
                    else
                        for(String s : q.split(" ")) {
                            if (!s.trim().isEmpty())
                                params.add(s.trim());
                        }
                    quoted = !quoted;
                }


                if(params.size()!=3 || !Constant.GENERATE_PAYSLIP_COMMAND.equalsIgnoreCase(params.get(0))){
                    System.out.println(Constant.INCORRECT_INPUT_PARAMETERS);
                }else{
                    try {
                        String name = params.get(1);
                        String annualSalary = params.get(2);
                        double salary = Double.parseDouble(annualSalary);

                        Employee employee = new Employee(name, salary);
                        employee.generatePaySlip();

                    }catch(EmployeeException ex){
                        logger.error(ex);
                        System.out.println(ex.getMessage());
                    }catch(PaySlipException ex) {
                        logger.error(ex);
                    }
                }
            }



        }
    }
}
