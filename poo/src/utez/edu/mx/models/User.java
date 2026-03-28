package utez.edu.mx.models;

// [T. Acceso] [T. Recurso] [Nombre clase] {}
public class User {
  private String name;
  private int age;
  private String email;

  //getters: aquellos que traen (get = traer)
    public int getAge() {
        return this.age;
    }

    public String getEmail(){
        return this.email;
    }

  // setters: aquellos que colocan (set = poner)
  public  void setName (String name){
        this.name = name;
  }

  public boolean validateData() {
      return true;
  }
}
