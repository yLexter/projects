package interfaces;

import entities.AcentoOnibus;

import java.util.List;

public interface IObserver {
    void update(List<AcentoOnibus> acentos);
}