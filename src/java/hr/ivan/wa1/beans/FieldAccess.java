package hr.ivan.wa1.beans;

/**
 *
 * @author ivans
 */
public class FieldAccess {

    private String type;
    private Object value;

    public FieldAccess(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("FieldAcces %s %s", type, value);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
