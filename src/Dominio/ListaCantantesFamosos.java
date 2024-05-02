package Dominio;
import Dominio.CantanteFamoso;

import java.util.ArrayList;

public class ListaCantantesFamosos {
    ArrayList<CantanteFamoso> listaCantantesFamosos;

    public ListaCantantesFamosos() {
        listaCantantesFamosos = new ArrayList<CantanteFamoso>();
    }

    public ArrayList<CantanteFamoso> getListaCantantesFamosos() {
        return listaCantantesFamosos;
    }
    public void agregarCantanteFamoso(CantanteFamoso cantanteFamoso) {
        listaCantantesFamosos.add(cantanteFamoso);
    }

    public void eliminarCantanteFamoso(String nombre) {
        for (CantanteFamoso cantanteFamoso : listaCantantesFamosos) {
            if (cantanteFamoso.getNombre().equals(nombre)) {
                listaCantantesFamosos.remove(cantanteFamoso);
                break;
            }
        }
    }
    public CantanteFamoso buscarCantanteFamoso(String nombre) {
        for (CantanteFamoso cantanteFamoso : listaCantantesFamosos) {
            if (cantanteFamoso.getNombre().equals(nombre)) {
                return cantanteFamoso;
            }
        }
        return null;
    }
}
