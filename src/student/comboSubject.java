package student;

//public class comboSubject {
//    
//    private  String key;
//    private  String value;
//
//
//
//  public comboSubject(String key, String value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return key;
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public String getValue() {
//        return value;
//    }
//}
public class comboSubject {
    private String key;
    private String value;

    public comboSubject(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString(){
        return key;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}