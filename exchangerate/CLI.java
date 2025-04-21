package exchangerate;

import java.net.URISyntaxException;
import org.apache.commons.cli.*;
import exchangerate.enums.Endpoint;

public class CLI {
	private final Options options = new Options();
	
	public CLI () {
		OptionGroup exclRequiredOptions = new OptionGroup();
		exclRequiredOptions.addOption(
			new Option("h", "help", false, Messages.get("cli.options.help")));
		exclRequiredOptions.addOption(
			new Option("l", "list", false, Messages.get("cli.options.list")));
		exclRequiredOptions.addOption(
			new Option("f", "from", true, Messages.get("cli.options.from")));
		options.addOptionGroup(exclRequiredOptions);
		options.addOption("t", "to", true, Messages.get("cli.options.to"));
		options.addOption("a", "amount", true, Messages.get("cli.options.amount"));
	}
	
	public void showHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(80, "\t" + 
					Messages.get("app.name") + " --help\t" +
					Messages.get("app.name") + " --list\t" + 
					Messages.get("app.name") + " --from COD [--to COD [--amount N]]\n\n",
				"", options, Config.prop("base.author"));
	}
	
	public Request parse(String[] args) {
		final CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			if(cmd.hasOption("list")) {
				return new Request(
						Utils.buildUrl(),
						Endpoint.SUPPORTED_CODES);
			} else if(cmd.hasOption("from")) {
				if(cmd.hasOption("to")) {
					if(cmd.hasOption("amount")) {
						return new Request(
								Utils.buildUrl(cmd.getOptionValue("from"), cmd.getOptionValue("to"), 
										Double.valueOf(cmd.getOptionValue("amount").replace(',','.'))), 
								Endpoint.PAIR_WITH_AMMOUNT);
					}
					return new Request(
							Utils.buildUrl(cmd.getOptionValue("from"), cmd.getOptionValue("to")),
							Endpoint.PAIR);
				}
				return new Request(
						Utils.buildUrl(cmd.getOptionValue("from")),
						Endpoint.STANDARD);
			}
		} catch (URISyntaxException e) {
			System.err.println("");
		} catch (AlreadySelectedException e) {
			System.err.println(Messages.get("cli.validation.list-from"));
		} catch (UnrecognizedOptionException e) {
			System.err.println(e.getMessage());
		} catch (ParseException e) {
			System.err.print(e.getMessage());
		}
		return null;		
	}
}
