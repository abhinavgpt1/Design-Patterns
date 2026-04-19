interface IMediator {
    void notify(Action action);
    void register(Action action, ICommand command);
}
