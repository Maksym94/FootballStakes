package sharedPlay;

import models.StakeModel;

public interface Stake {
	
	public boolean makeStake(StakeModel model);
	public boolean cancelStake(StakeModel model);

}
