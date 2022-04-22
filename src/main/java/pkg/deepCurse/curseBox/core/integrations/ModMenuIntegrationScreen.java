package pkg.deepCurse.curseBox.core.integrations;

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
import pkg.deepCurse.curseBox.core.CurseBox;

public class ModMenuIntegrationScreen extends Screen {
	Screen parent;

	public ModMenuIntegrationScreen(Screen parent) {
		super(new TranslatableText("cursebox.config.menu.title"));
		this.parent = parent;
	}
	@Override
	protected void init() {
		this.addDrawableChild(new ButtonWidget(14, 14, 49, 10,
				new TranslatableText("cursebox.menu.return"),
				(buttonWidget) -> {
					if (CurseBox.debug) {
						CurseBox.LOGGER
								.info("Config menu return button is pressed");
					}
					
					

					this.client.setScreen(this.parent);
				}));
		String fogButtonStartingName;
		if (CurseBox.enableCustomFog) {
			fogButtonStartingName = "cursebox.config.menu.fog.on";
		} else {
			fogButtonStartingName = "cursebox.config.menu.fog.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 24, 49, 10,
				new TranslatableText(fogButtonStartingName), (buttonWidget) -> {
					if (CurseBox.debug) {
						CurseBox.LOGGER
								.info("Config menu fog button is pressed");
					}

					if (CurseBox.enableCustomFog) {
						CurseBox.enableCustomFog = false;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.fog.off"));
					} else {
						CurseBox.enableCustomFog = true;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.fog.on"));
					}

					CurseBox.LOGGER.info(
							"Changed value to: " + CurseBox.enableCustomFog);
				}));
		String debugButtonStartingName;
		if (CurseBox.debug) {
			debugButtonStartingName = "cursebox.config.menu.debug.on";
		} else {
			debugButtonStartingName = "cursebox.config.menu.debug.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 34, 90, 10,
				new TranslatableText(debugButtonStartingName),
				(buttonWidget) -> {
					if (CurseBox.debug) {
						CurseBox.LOGGER
								.info("Config menu debug button is pressed");
					}

					if (CurseBox.debug) {
						CurseBox.debug = false;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.debug.off"));
					} else {
						CurseBox.debug = true;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.debug.on"));
					}

					CurseBox.LOGGER.info("Changed value to: " + CurseBox.debug);
				}));
		String attackOnlyPlayersButtonStartingName;
		if (CurseBox.attackOnlyPlayers) {
			attackOnlyPlayersButtonStartingName = "cursebox.config.menu.attack.only.players.on";
		} else {
			attackOnlyPlayersButtonStartingName = "cursebox.config.menu.attack.only.players.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 44, 165, 10,
				new TranslatableText(attackOnlyPlayersButtonStartingName),
				(buttonWidget) -> {
					if (CurseBox.debug) {
						CurseBox.LOGGER.info(
								"Config menu attack only players button is pressed");
					}

					if (CurseBox.attackOnlyPlayers) {
						CurseBox.attackOnlyPlayers = false;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.attack.only.players.off"));
					} else {
						CurseBox.attackOnlyPlayers = true;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.attack.only.players.on"));
					}

					CurseBox.LOGGER.info(
							"Changed value to: " + CurseBox.attackOnlyPlayers);
				}));
		String resetChanceButtonStartingName;
		if (CurseBox.resetChance) {
			resetChanceButtonStartingName = "cursebox.config.menu.reset.chance.on";
		} else {
			resetChanceButtonStartingName = "cursebox.config.menu.reset.chance.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 54, 200, 10,
				new TranslatableText(resetChanceButtonStartingName),
				(buttonWidget) -> {
					if (CurseBox.debug) {
						CurseBox.LOGGER.info(
								"Config menu reset chance button is pressed");
					}

					if (CurseBox.resetChance) {
						CurseBox.resetChance = false;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.reset.chance.off"));
					} else {
						CurseBox.resetChance = true;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.reset.chance.on"));
					}

					CurseBox.LOGGER
							.info("Changed value to: " + CurseBox.resetChance);
				}));
		String supremeDebugButtonStartingName;
		if (CurseBox.supremeDebug) {
			supremeDebugButtonStartingName = "cursebox.config.menu.supreme.debug.on";
		} else {
			supremeDebugButtonStartingName = "cursebox.config.menu.supreme.debug.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 64, 130, 10,
				new TranslatableText(supremeDebugButtonStartingName),
				(buttonWidget) -> {
					if (CurseBox.debug) {
						CurseBox.LOGGER.info(
								"Config menu supreme debug button is pressed");
					}

					if (CurseBox.supremeDebug) {
						CurseBox.supremeDebug = false;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.supreme.debug.off"));
					} else {
						CurseBox.supremeDebug = true;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.supreme.debug.on"));
					}

					CurseBox.LOGGER
							.info("Changed value to: " + CurseBox.supremeDebug);
				}));
		String accerlerateTorchDeathButtonStartingName;
		if (CurseBox.accelerateTorchDeath) {
			accerlerateTorchDeathButtonStartingName = "cursebox.config.menu.fast.torches.on";
		} else {
			accerlerateTorchDeathButtonStartingName = "cursebox.config.menu.fast.torches.off";
		}

		this.addDrawableChild(new ButtonWidget(14, 74, 135, 10,
				new TranslatableText(accerlerateTorchDeathButtonStartingName),
				(buttonWidget) -> {
					if (CurseBox.debug) {
						CurseBox.LOGGER.info(
								"Config menu supreme debug button is pressed");
					}

					if (CurseBox.accelerateTorchDeath) {
						CurseBox.accelerateTorchDeath = false;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.fast.torches.off"));
					} else {
						CurseBox.accelerateTorchDeath = true;
						buttonWidget.setMessage(new TranslatableText(
								"cursebox.config.menu.fast.torches.on"));
					}

					CurseBox.LOGGER.info("Changed value to: "
							+ CurseBox.accelerateTorchDeath);
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
		RenderSystem.setShaderTexture(0, new Identifier("minecraft", "textures/block/cobbled_deepslate.png"));
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
