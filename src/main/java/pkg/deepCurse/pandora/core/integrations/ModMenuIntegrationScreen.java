package pkg.deepCurse.pandora.core.integrations;

import java.io.IOException;
import java.nio.file.Files;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import pkg.deepCurse.pandora.core.Pandora;
import pkg.deepCurse.pandora.core.PandoraConfig;

public class ModMenuIntegrationScreen extends Screen {
	Screen parent;

	public ModMenuIntegrationScreen(Screen parent) {
		super(new TranslatableText("pandora.config.menu.title"));
		this.parent = parent;
	}
	@Override
	protected void init() {
		this.addDrawableChild(new ButtonWidget(14, 14, 49, 10,
				new TranslatableText("pandora.menu.return"),
				(buttonWidget) -> {
					if (Pandora.debug) {
						Pandora.LOGGER
								.info("Config menu return button is pressed");
					}

					this.client.setScreen(this.parent);
				}));
		String fogButtonStartingName;
		if (PandoraConfig.enableCustomFog) {
			fogButtonStartingName = "pandora.config.menu.fog.on";
		} else {
			fogButtonStartingName = "pandora.config.menu.fog.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 24, 49, 10,
				new TranslatableText(fogButtonStartingName), (buttonWidget) -> {
					if (Pandora.debug) {
						Pandora.LOGGER
								.info("Config menu fog button is pressed");
					}

					if (PandoraConfig.enableCustomFog) {
						PandoraConfig.enableCustomFog = false;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.fog.off"));
					} else {
						PandoraConfig.enableCustomFog = true;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.fog.on"));
					}

					Pandora.LOGGER.info("Changed value to: "
							+ PandoraConfig.enableCustomFog);
				}));
		String debugButtonStartingName;
		if (Pandora.debug) {
			debugButtonStartingName = "pandora.config.menu.debug.on";
		} else {
			debugButtonStartingName = "pandora.config.menu.debug.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 34, 90, 10,
				new TranslatableText(debugButtonStartingName),
				(buttonWidget) -> {
					if (Pandora.debug) {
						Pandora.LOGGER
								.info("Config menu debug button is pressed");
					}

					if (Pandora.debug) {
						Pandora.debug = false;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.debug.off"));
					} else {
						Pandora.debug = true;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.debug.on"));
					}

					Pandora.LOGGER.info("Changed value to: " + Pandora.debug);
				}));
		String attackOnlyPlayersButtonStartingName;
		if (PandoraConfig.gruesOnlyAttackPlayers) {
			attackOnlyPlayersButtonStartingName = "pandora.config.menu.attack.only.players.on";
		} else {
			attackOnlyPlayersButtonStartingName = "pandora.config.menu.attack.only.players.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 44, 165, 10,
				new TranslatableText(attackOnlyPlayersButtonStartingName),
				(buttonWidget) -> {
					if (Pandora.debug) {
						Pandora.LOGGER.info(
								"Config menu attack only players button is pressed");
					}

					if (PandoraConfig.gruesOnlyAttackPlayers) {
						PandoraConfig.gruesOnlyAttackPlayers = false;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.attack.only.players.off"));
					} else {
						PandoraConfig.gruesOnlyAttackPlayers = true;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.attack.only.players.on"));
					}

					Pandora.LOGGER.info("Changed value to: "
							+ PandoraConfig.gruesOnlyAttackPlayers);
				}));
		String resetChanceButtonStartingName;
		if (PandoraConfig.resetGrueAttackChance) {
			resetChanceButtonStartingName = "pandora.config.menu.reset.chance.on";
		} else {
			resetChanceButtonStartingName = "pandora.config.menu.reset.chance.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 54, 200, 10,
				new TranslatableText(resetChanceButtonStartingName),
				(buttonWidget) -> {

					if (PandoraConfig.resetGrueAttackChance) {
						PandoraConfig.resetGrueAttackChance = false;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.reset.chance.off"));
					} else {
						PandoraConfig.resetGrueAttackChance = true;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.reset.chance.on"));
					}

					Pandora.LOGGER.info("Changed value to: "
							+ PandoraConfig.resetGrueAttackChance);
				}));

		String accerlerateTorchDeathButtonStartingName;
		if (PandoraConfig.accelerateTorchDeath) {
			accerlerateTorchDeathButtonStartingName = "pandora.config.menu.fast.torches.on";
		} else {
			accerlerateTorchDeathButtonStartingName = "pandora.config.menu.fast.torches.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 74, 135, 10,
				new TranslatableText(accerlerateTorchDeathButtonStartingName),
				(buttonWidget) -> {

					if (PandoraConfig.accelerateTorchDeath) {
						PandoraConfig.accelerateTorchDeath = false;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.fast.torches.off"));
					} else {
						PandoraConfig.accelerateTorchDeath = true;
						buttonWidget.setMessage(new TranslatableText(
								"pandora.config.menu.fast.torches.on"));
					}

					Pandora.LOGGER.info("Changed value to: "
							+ PandoraConfig.accelerateTorchDeath);
				}));

		this.addDrawableChild(new ButtonWidget(14, 94, 165, 10,
				new TranslatableText("pandora.config.menu.reload.config"),
				(buttonWidget) -> {
					if (Pandora.debug) {
						Pandora.LOGGER.info("[pandora] Reloading Configs");
					}
					PandoraConfig.loadConfig();
				}));

		this.addDrawableChild(new ButtonWidget(14, 104, 165, 10,
				new TranslatableText("pandora.config.menu.delete.config"),
				(buttonWidget) -> {
					if (Pandora.debug) {
						Pandora.LOGGER.info("[pandora] Deleting Configs");
					}
					try {
						Files.delete(PandoraConfig.getConfigFile().toPath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}));
		this.addDrawableChild(new ButtonWidget(14, 114, 165, 10,
				new TranslatableText("pandora.config.menu.save.config"),
				(buttonWidget) -> {
					if (Pandora.debug) {
						Pandora.LOGGER.info("[pandora] Saving Configs");
					}
					PandoraConfig.saveConfigs();
				}));
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY,
			float delta) {
		MatrixStack mats = new MatrixStack();
		int vOffset = 0;
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferBuilder = tessellator.getBuffer();
		// this.client.getTextureManager().bindTexture(
		// new Identifier("minecraft", "textures/block/cobbled_deepslate.png"));
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
		RenderSystem.setShaderTexture(0, new Identifier("minecraft",
				"textures/block/cobbled_deepslate.png"));
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		bufferBuilder.begin(DrawMode.QUADS,
				VertexFormats.POSITION_TEXTURE_COLOR);
		bufferBuilder.vertex(0.0D, (double) this.height, 0.0D)
				.texture(0.0F, (float) this.height / 32.0F + (float) vOffset)
				.color(64, 64, 64, 255).next();
		bufferBuilder.vertex((double) this.width, (double) this.height, 0.0D)
				.texture((float) this.width / 32.0F,
						(float) this.height / 32.0F + (float) vOffset)
				.color(64, 64, 64, 255).next();
		bufferBuilder.vertex((double) this.width, 0.0D, 0.0D)
				.texture((float) this.width / 32.0F, (float) vOffset)
				.color(64, 64, 64, 255).next();
		bufferBuilder.vertex(0.0D, 0.0D, 0.0D).texture(0.0F, (float) vOffset)
				.color(64, 64, 64, 255).next();
		tessellator.draw();
		drawCenteredText(mats, this.textRenderer, this.title, this.width / 2,
				15, 16777215);
		super.render(mats, mouseX, mouseY, delta);
	}
}
