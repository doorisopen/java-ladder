package step4.domain;

import java.util.Objects;

public class Reward {
    private final Name name;

    private Reward(String name) {
        this.name = Name.of(name);
    }

    public static Reward of(String name) {
        return new Reward(name);
    }

    public String name() {
        return name.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
