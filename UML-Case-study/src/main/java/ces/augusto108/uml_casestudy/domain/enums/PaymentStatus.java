package ces.augusto108.uml_casestudy.domain.enums;

public enum PaymentStatus {
    PENDING(0, "Pendente"),
    CONFIRMED(1, "Realizado"),
    CANCELED(2, "Cancelado");

    private final int id;
    private final String description;

    private PaymentStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStatus convertToEnum(Integer id) {
        if (id == null) return null;

        for (PaymentStatus type : PaymentStatus.values()) {
            if (id.equals(type.getId())) return type;
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }
}
