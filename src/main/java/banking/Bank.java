package banking;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
    private AtomicLong accountNumberGenerator = new AtomicLong(0);

	public Bank() {
		// complete the function
    this.accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
    long accountNumber = generateAccountNumber();
    Account account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
    accounts.put(accountNumber, account);
    return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
    long accountNumber = generateAccountNumber();
    Account account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
    accounts.put(accountNumber, account);
    return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
      Account account = getAccount(accountNumber);
      return !Objects.isNull(account) && account.validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
    Account account = getAccount(accountNumber);
    return !Objects.isNull(account) ? account.getBalance() : -1;
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
    Account account = getAccount(accountNumber);
    if(!Objects.isNull(account)) {
      account.creditAccount(amount);
    }
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
    Account account = getAccount(accountNumber);
    if(!Objects.isNull(account)) {
      return account.debitAccount(amount);
    }
    return false;
	}

  private long generateAccountNumber() {
    return accountNumberGenerator.incrementAndGet();
  }
}
