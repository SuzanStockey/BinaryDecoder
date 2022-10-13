import java.nio.charset.StandardCharsets;

public class Binary {
    private Integer bits = 0;
    private String value = "";

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
        double decimalNoSignal = 0.0;
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
            if (i == 0){
                if ("1".equalsIgnoreCase(String.valueOf(value.charAt(i)))){
                    sinal = "-";
                }
            } else {
                if ("1".equalsIgnoreCase(String.valueOf(value.charAt(i)))) {
                    decimal2Complement += Math.pow(2, (value.length() - 1 - i));
                }
            }
        }
        return sinal + String.format("%.0f", decimal2Complement);
    }

    public String character() {
        if (bits > value.length()){
            while(value.length() < bits){
                value = "0".concat(value);
            }
        }
        byte[] ret = new byte[value.length() / 8];
        for (int i = 1; i <= ret.length; i++) {
            String chunk = value.substring(i * 8, i * 8 + 8);
            ret[i] = (byte) Short.parseShort(chunk, 2);
        }
        return new String(ret, StandardCharsets.UTF_8);
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
