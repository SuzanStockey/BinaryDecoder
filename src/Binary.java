import java.nio.charset.StandardCharsets;

public class Binary {
    private Integer bits = 0;
    private String value = "";
    private double decimalNoSignal = 0.0;

    public boolean isBinary(){
        for(int i = 0; i < value.length(); i++){
            if(!"1".equalsIgnoreCase(String.valueOf(value.charAt(i))) && !"0".equalsIgnoreCase(String.valueOf(value.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public String valueDecimalNoSignal(){
        while(value.length() < bits){
            value = "0".concat(value);
        }
        for (int i = 0; i < value.length(); i++){
            if("1".equalsIgnoreCase(String.valueOf(value.charAt(i)))) {
                decimalNoSignal += Math.pow(2, (value.length() - 1 - i));
            }
        }
        return String.format("%.0f", decimalNoSignal);
    }

    public String valueDecimal2Complement(){
        while(value.length() < bits){
            value = "0".concat(value);
        }

        double decimal2Complement = 0.0;
        String sinal = "";
        for (int i = 0; i < value.length(); i++){
            if ("1".equalsIgnoreCase(String.valueOf(value.charAt(i)))) {
                if (i == 0) {
                    decimal2Complement -= Math.pow(2, (value.length() - 1 - i));
                } else {
                    decimal2Complement += Math.pow(2, (value.length() - 1 - i));
                }
            }
        }
        return String.format("%.0f", decimal2Complement);
    }

    public String character() {
        return String.valueOf(Character.toChars(Integer.parseInt(String.format("%.0f", decimalNoSignal))));
    }

    public Integer getBits() {
        return bits;
    }

    public void setBits(Integer bits) {
        this.bits = bits;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
