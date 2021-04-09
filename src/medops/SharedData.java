package medops;

import medops.screens.EmployeeScreen;

public class SharedData {
    public static Medicine selectedMedicine;
    public static Employee currentEmployee;

    public static boolean processTransaction(TransactionRecord record){
        boolean allOkay = true;
        int addOrSubtract;

        if(record.getType().equals("Sale")){
            addOrSubtract = 1;
        } else {
            addOrSubtract = -1;
        }

        for(TransactedMedicine medicine: record.getMedicines()){
            allOkay &= doesMedicineExist(medicine, addOrSubtract);
        }

        if(allOkay){
            System.out.println("Transaction recorded at " + record.getTimeOfPurchase() + " by Employee ID " + record.getEmployeeId());
        } else {
            System.out.println("Problem recording Transaction at " + record.getTimeOfPurchase() + " by Employee ID " + record.getEmployeeId());
        }
        return allOkay;
    }

    static boolean doesMedicineExist(TransactedMedicine transactedMedicine, int multiplier){
        boolean everythingChecksOut = false;
        for(Medicine med: EmployeeScreen.storeRecord.medicineList){
            if(med.getName().equals(transactedMedicine.getMedicineName())){
                if(transactedMedicine.getQty()*multiplier <= med.getQty()){
                    everythingChecksOut = true;
                    med.setQty(med.getQty() - (multiplier * transactedMedicine.getQty()));
                }
            }
        }
        return everythingChecksOut;
    }
}
