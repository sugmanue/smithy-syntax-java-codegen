package mx.sugus.syntax.java;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.element.Modifier;
import mx.sugus.util.CollectionBuilderReference;

public final class InterfaceSyntax implements TypeSyntax {
    private final String name;

    private final Set<Modifier> modifiers;

    private final List<Annotation> annotations;

    private final List<FieldSyntax> fields;

    private final List<MethodSyntax> methods;

    private InterfaceSyntax(Builder builder) {
        this.name = Objects.requireNonNull(builder.name, "name");
        this.modifiers = builder.modifiers.asPersistent();
        this.annotations = builder.annotations.asPersistent();
        this.fields = builder.fields.asPersistent();
        this.methods = builder.methods.asPersistent();
    }

    public String name() {
        return this.name;
    }

    public Set<Modifier> modifiers() {
        return this.modifiers;
    }

    public List<Annotation> annotations() {
        return this.annotations;
    }

    public List<FieldSyntax> fields() {
        return this.fields;
    }

    public List<MethodSyntax> methods() {
        return this.methods;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof InterfaceSyntax)) {
            return false;
        }
        InterfaceSyntax other = (InterfaceSyntax) obj;
        return this.name.equals(other.name)
             && this.modifiers.equals(other.modifiers)
             && this.annotations.equals(other.annotations)
             && this.fields.equals(other.fields)
             && this.methods.equals(other.methods);
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + name.hashCode();
        hashCode = 31 * hashCode + modifiers.hashCode();
        hashCode = 31 * hashCode + annotations.hashCode();
        hashCode = 31 * hashCode + fields.hashCode();
        hashCode = 31 * hashCode + methods.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "InterfaceSyntax{"
             + "name: " + name
             + ", modifiers: " + modifiers
             + ", annotations: " + annotations
             + ", fields: " + fields
             + ", methods: " + methods + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public <T> T accept(SyntaxNodeVisitor<T> visitor) {
        return visitor.visitInterfaceSyntax(this);
    }

    public static final class Builder {
        private String name;

        private CollectionBuilderReference<Set<Modifier>> modifiers;

        private CollectionBuilderReference<List<Annotation>> annotations;

        private CollectionBuilderReference<List<FieldSyntax>> fields;

        private CollectionBuilderReference<List<MethodSyntax>> methods;

        private boolean _built;

        Builder() {
            this.modifiers = CollectionBuilderReference.forOrderedSet();
            this.annotations = CollectionBuilderReference.forList();
            this.fields = CollectionBuilderReference.forList();
            this.methods = CollectionBuilderReference.forList();
        }

        Builder(InterfaceSyntax data) {
            this.name = data.name;
            this.modifiers = CollectionBuilderReference.fromPersistentOrderedSet(data.modifiers);
            this.annotations = CollectionBuilderReference.fromPersistentList(data.annotations);
            this.fields = CollectionBuilderReference.fromPersistentList(data.fields);
            this.methods = CollectionBuilderReference.fromPersistentList(data.methods);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder modifiers(Set<Modifier> modifiers) {
            this.modifiers.clear();
            this.modifiers.asTransient().addAll(modifiers);
            return this;
        }

        public Builder addModifier(Modifier modifier) {
            this.modifiers.asTransient().add(modifier);
            return this;
        }

        public Builder annotations(List<Annotation> annotations) {
            this.annotations.clear();
            this.annotations.asTransient().addAll(annotations);
            return this;
        }

        public Builder addAnnotation(Annotation annotation) {
            this.annotations.asTransient().add(annotation);
            return this;
        }

        public Builder fields(List<FieldSyntax> fields) {
            this.fields.clear();
            this.fields.asTransient().addAll(fields);
            return this;
        }

        public Builder addField(FieldSyntax field) {
            this.fields.asTransient().add(field);
            return this;
        }

        public Builder methods(List<MethodSyntax> methods) {
            this.methods.clear();
            this.methods.asTransient().addAll(methods);
            return this;
        }

        public Builder addMethod(MethodSyntax method) {
            this.methods.asTransient().add(method);
            return this;
        }

        public InterfaceSyntax build() {
            return new InterfaceSyntax(this);
        }
    }
}
