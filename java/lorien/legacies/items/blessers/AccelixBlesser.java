package lorien.legacies.items.blessers;

import lorien.legacies.core.LorienLegacies;
import lorien.legacies.legacies.LegacyManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class AccelixBlesser extends Item {
	
	private static String UNLOCALIZED_NAME = "accelixblesser";
	
	public AccelixBlesser()
	{
		setUnlocalizedName(LorienLegacies.MODID + "." + UNLOCALIZED_NAME);
		setRegistryName(new ResourceLocation(LorienLegacies.MODID, UNLOCALIZED_NAME));
		setCreativeTab(LorienLegacies.instance.blessersTab);
		setMaxStackSize(1);
		setMaxDamage(0);
	}
	
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		// Give player using it legacy by finding LegacyManager with player UUID that corresponds to player that is using the item's UUID
		for (LegacyManager l : LorienLegacies.legacyManagers)
		{
			if (l.player.getUniqueID() == player.getUniqueID() && player.world.isRemote == false)
			{
				l.legaciesEnabled = true;
				l.accelixLegacyEnabled = true;
				l.player.sendMessage(new TextComponentString("You have been blessed with accelix - grants toggleable super speed (currently enabled)").setStyle(new Style().setColor(TextFormatting.YELLOW)));
			}
		}
		
        return EnumActionResult.PASS;
    }
    
	
}
