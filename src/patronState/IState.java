package patronState;

public interface IState {
	void ponerActivo();
	void ponerSuspendido();
	void ponerCancelado();
	void ponerFinalizado();
}
