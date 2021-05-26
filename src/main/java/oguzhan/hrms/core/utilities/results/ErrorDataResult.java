package oguzhan.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
	
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}
	
	public ErrorDataResult(T data) {
		super(data, false);
	}
	
	public ErrorDataResult() {
		super(null, false);
	}
	
	public ErrorDataResult(String message) {
		super(null, false, message);
	}
}