package com.keithsmyth.firefly.view;

import android.os.Bundle;

/**
 * @author keithsmyth
 */
public interface Navigatable {

  void navigate(Class<?> fragmentClass, Bundle args);
}
