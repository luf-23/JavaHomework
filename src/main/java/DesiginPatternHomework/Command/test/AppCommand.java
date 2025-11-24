package DesiginPatternHomework.Command.test;

import DesiginPatternHomework.Command.Command;

/**
 * 应用程序启动命令
 */
class AppStartCommand implements Command {
    private Application app;

    public AppStartCommand(Application app) {
        this.app = app;
    }

    @Override
    public void execute() {
        app.start();
    }

    @Override
    public void undo() {
        app.close();
    }

    @Override
    public String getObjectName() {
        return app.getName();
    }
}

/**
 * 应用程序关闭命令
 */
class AppCloseCommand implements Command {
    private Application app;

    public AppCloseCommand(Application app) {
        this.app = app;
    }

    @Override
    public void execute() {
        app.close();
    }

    @Override
    public void undo() {
        app.start();
    }

    @Override
    public String getObjectName() {
        return app.getName();
    }
}
