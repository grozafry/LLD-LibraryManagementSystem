package utils;

public class RetryUtil {    

    public static boolean retryInstantOperation(Runnable operation, int maxRetries){
        int tryCount=0;
        while(tryCount<maxRetries){
            try {
                operation.run();
                return true;
            } catch (Exception e) {
                System.out.println("Failed. Retrying...");
                tryCount+=1;    
            }
            
        }
        System.out.println("Maximum retry count exceeded. Operation failed!");
        return false;
    }

    public static boolean retryExponentialOperation(Runnable operation, int maxRetries){
        int tryCount=0;
        int sleepTime = 10;
        while(tryCount<maxRetries){
            try {
                tryCount+=1;   
                operation.run();
                return true;
            } catch (Exception e1) {
                System.out.println("Failed. Retrying in " + sleepTime + " ...");
                try{
                    Thread.sleep(sleepTime);
                }catch(InterruptedException e2){
                    Thread.currentThread().interrupt();
                    return false;
                }
                
                sleepTime = sleepTime * 200;
            }
            
        }
        System.out.println("Maximum retry count exceeded. Operation failed!");
        return false;
    }

}
