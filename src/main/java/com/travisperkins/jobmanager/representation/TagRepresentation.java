package com.travisperkins.jobmanager.representation;

/**
 * Created by msamandi on 07/03/2017.
 */

public class TagRepresentation {

    private String name;

    public TagRepresentation(TagRepresentationBuilder tagRepresentationBuilder) {
        this.name = tagRepresentationBuilder.name;
    }

    public TagRepresentation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class TagRepresentationBuilder {
        private String name;

        public TagRepresentationBuilder(String name) {
            this.name = name;
        }

        public TagRepresentation build() {
            return new TagRepresentation(this);
        }
    }

}
