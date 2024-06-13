package pl.javastart.task.objects;

import java.math.BigDecimal;
import java.util.Objects;

public class Currency {
    private String name;
    private BigDecimal value;

    public Currency(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + ';' + value + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Currency currency = (Currency) o;
        return Objects.equals(name, currency.name) && Objects.equals(value, currency.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
