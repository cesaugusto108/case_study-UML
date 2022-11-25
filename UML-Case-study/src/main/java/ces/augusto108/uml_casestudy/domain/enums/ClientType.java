package ces.augusto108.uml_casestudy.domain.enums;

public enum ClientType {
    INDIVIDUAL(0, "Pessoa física"),
    CORPORATE(1, "Pessoa jurídica");

    private final int id;
    private final String description;

    private ClientType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static ClientType convertToEnum(Integer id) {
        if (id == null) return null;

        for (ClientType type : ClientType.values()) {
            if (id.equals(type.getId())) return type;
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }
}
