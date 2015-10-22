package ru.kpsug.db;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Film {
    private ArrayList<String> suggestion_links = new ArrayList<>();
    private String id = null;
    private String name = null;
    private String annotation = null;
    private String rating = null;
    private TreeMap<String, ArrayList<String> > purposes = new TreeMap<>();
    private ArrayList<String> actors =new ArrayList<String>();
    
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    
    public ArrayList<String> getSuggestion_links() {
        return suggestion_links;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAnnotation() {
        return annotation;
    }
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
    public TreeMap<String, ArrayList<String>> getPurposes() {
        return purposes;
    }
    public void setPurposes(TreeMap<String, ArrayList<String>> purposes) {
        this.purposes = purposes;
    }
    public ArrayList<String> getActors() {
        return actors;
    }
    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }
    public void setSuggestion_links(ArrayList<String> suggestion_links) {
        this.suggestion_links = suggestion_links;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    
    public void addPurpose(String key, String value){
        if(!purposes.containsKey(key)){
            purposes.put(key, new ArrayList<String>());
        }
        purposes.get(key).add(value);
    }
    
    public void addActor(String name){
        actors.add(name);
    }
    
    
    public void print(OutputStream stream) throws IOException{
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        writer.append("id=" + id + "\n");
        writer.append("name=" + name + "\n");
        writer.append("annotation=" + annotation + "\n");
        writer.append("rating=" + rating + "\n");
        writer.append("actors=" + actors + "\n");
        writer.append("purposes=" + purposes + "\n");
        writer.append("suggestions=" + suggestion_links + "\n");
        writer.flush();
    }
    
    @Override
    public boolean equals(Object obj) {
        Film with = (Film) obj;
        return id.toString().equals(with.id.toString()) && name.toString().equals(with.name.toString()) &&
                purposes.toString().equals(with.purposes.toString()) &&  actors.toString().equals(with.actors.toString())
                && annotation.toString().equals(with.annotation.toString()) && suggestion_links.toString().equals(with.suggestion_links.toString()) &&
                rating.toString().equals(with.rating.toString());
    }
    
    public void addSuggestionLink(String link){
        suggestion_links.add(link);
    }
}