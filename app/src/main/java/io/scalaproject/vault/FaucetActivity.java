// Copyright (c) 2021 Scala
//
// Please see the included LICENSE file for more information.

package io.scalaproject.vault;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class FaucetActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }

        setContentView(R.layout.fragment_forgottenmines);

        // Animación del título
        View vaultTitle = findViewById(R.id.llVaultTitle);
        vaultTitle.setAlpha(0f);
        vaultTitle.setTranslationY(-80f);

        vaultTitle.animate()
                .alpha(1f)
                .translationY(0)
                .setDuration(600)
                .setStartDelay(200)
                .start();
    }

    public void onCloseVault(View view) {
        view.animate()
                .rotationBy(90f)
                .setDuration(200)
                .withEndAction(() -> super.onBackPressed())
                .start();
    }

    public void onFaucetPlay(View view) {
        view.animate()
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(100)
                .withEndAction(() -> {
                    view.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(100)
                            .start();

                    Uri uri = Uri.parse(getResources().getString(R.string.faucet_url));
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                })
                .start();
    }
}