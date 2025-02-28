import { WebPlugin } from '@capacitor/core';

import type { NativeARViewerPlugin } from './definitions';

export class NativeARViewerWeb extends WebPlugin implements NativeARViewerPlugin {
  async openAR(options: { value: string }): Promise<{ value: string }> {
    console.log('OPEN AR', options);
    return options;
  }
}
