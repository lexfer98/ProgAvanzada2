package modelo.Clases;

import modelo.Genericidad.tieneClave;
import modelo.Genericidad.tieneLista;
import modelo.Resultados.Resultado;
import modelo.Strategy.Facturacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tarea implements Serializable, tieneLista, tieneClave {

    private String titulo;
    private String descripcion;
    private List<Personas> colaboradores = new ArrayList<>();
    private String responsable;
    private int prioridad;
    private LocalDate FechaInicio;
    private LocalDate FechaFin;
    private boolean finalizado;
    private Resultado result;
    private List<String> etiquetas = new ArrayList<>();
    private double coste;
    private Facturacion factura;


    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public Facturacion getFactura() {
        return factura;
    }

    public void setFactura(Facturacion factura) {
        this.factura = factura;
    }

    public Tarea(String titulo, String descripcion, String responsable, int prioridad,
                 LocalDate FechaInicio, LocalDate FechaFin, boolean finalizado, Resultado result, double coste, Facturacion factura){
        this.titulo = titulo;
        this.descripcion= descripcion;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.finalizado = finalizado;
        this.result = result;
        this.coste = coste;
        this.factura = factura;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Personas> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Personas> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public void anyadirColaborador(Personas nombre){
        colaboradores.add(nombre);
    }

    public void eliminarColaborador(Personas nombre){
        colaboradores.remove(nombre);
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Resultado getResult() {
        return result;
    }

    public void setResult(Resultado result) {
        this.result = result;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void finalizarTarea(){
        setFinalizado(true);
    }
    public boolean contienePersona(Personas p){
        for(Personas per:colaboradores){
            if (per.equals(p)){
                return true;
            }
        }
        return false;
    }
    public double calcularImporte(){
        return factura.coste(coste);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea)) return false;
        Tarea tarea = (Tarea) o;
        return Objects.equals(titulo, tarea.titulo);
    }



    @Override
    public List getLista() {
        return colaboradores;
    }

    @Override
    public Object getClave() {
        return titulo;
    }
}