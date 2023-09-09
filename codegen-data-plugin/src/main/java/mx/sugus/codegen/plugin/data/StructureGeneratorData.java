package mx.sugus.codegen.plugin.data;

import mx.sugus.codegen.plugin.AbstractShapeTask;
import mx.sugus.codegen.plugin.Identifier;
import mx.sugus.codegen.plugin.JavaShapeDirective;
import mx.sugus.codegen.plugin.TypeSpecResult;
import mx.sugus.javapoet.TypeSpec;
import mx.sugus.syntax.java.InterfaceTrait;
import mx.sugus.syntax.java.JavaTrait;
import software.amazon.smithy.model.shapes.ShapeType;

public class StructureGeneratorData extends AbstractShapeTask<TypeSpecResult> {
    public static final Identifier ID = Identifier.of(StructureGeneratorData.class);

    public StructureGeneratorData() {
        super(ID, TypeSpecResult.class, ShapeType.STRUCTURE);
    }

    @Override
    public TypeSpecResult produce(JavaShapeDirective directive) {
        var shape = directive.shape();
        if (shape.hasTrait(JavaTrait.class)) {
            return null;
        }
        TypeSpec spec;
        if (shape.hasTrait(InterfaceTrait.class)) {
            spec = new InterfaceStructureGenerator().build(directive);
        } else {
            spec = new BaseStructureData().build(directive);
        }
        return TypeSpecResult.builder()
                             .spec(spec)
                             .build();
    }
}
