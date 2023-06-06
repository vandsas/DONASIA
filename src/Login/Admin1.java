/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author bagas
 */
public class Admin1 extends AdminParent{
    
    String Username = "DaniTampan";
    String Password = "123456";

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return Username;
    }
    
}
