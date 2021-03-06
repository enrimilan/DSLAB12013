package util;

import cli.Shell;
import client.ClientCli;
import client.IClientCli;
import proxy.IProxyCli;
import proxy.Proxy;
import proxy.ProxyCli;
import server.FileServer;
import server.FileServerCli;
import server.IFileServerCli;

/**
 * Provides methods for starting an arbitrary amount of various components.
 */
public class ComponentFactory {
	/**
	 * Creates and starts a new client instance using the provided {@link Config} and {@link Shell}.
	 *
	 * @param config the configuration containing parameters such as connection info
	 * @param shell  the {@code Shell} used for processing commands
	 * @return the created component after starting it successfully
	 * @throws Exception if an exception occurs
	 */
	public IClientCli startClient(Config config, Shell shell) throws Exception {
		ClientCli clientCli = new ClientCli(config, shell);
		shell.register(clientCli);
		clientCli.startClient();
		return clientCli;
	}

	/**
	 * Creates and starts a new proxy instance using the provided {@link Config} and {@link Shell}.
	 *
	 * @param config the configuration containing parameters such as connection info
	 * @param shell  the {@code Shell} used for processing commands
	 * @return the created component after starting it successfully
	 * @throws Exception if an exception occurs
	 */
	public IProxyCli startProxy(Config config, Shell shell) throws Exception {
		Proxy proxy = new Proxy(config, shell);
		ProxyCli proxyCli = new ProxyCli(proxy);
		shell.register(proxyCli);
		proxy.startProxy();
		return proxyCli;
	}

	/**
	 * Creates and starts a new file server instance using the provided {@link Config} and {@link Shell}.
	 *
	 * @param config the configuration containing parameters such as connection info
	 * @param shell  the {@code Shell} used for processing commands
	 * @return the created component after starting it successfully
	 * @throws Exception if an exception occurs
	 */
	public IFileServerCli startFileServer(Config config, Shell shell) throws Exception {
		FileServer fileServer = new FileServer(config, shell);
		FileServerCli fileServerCli = new FileServerCli(fileServer);
		shell.register(fileServerCli);
		fileServer.startFileServer();
		return fileServerCli;
	}
}
