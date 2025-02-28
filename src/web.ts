import { WebPlugin } from '@capacitor/core';

import type { NativeARViewerPlugin } from './definitions';

export class NativeARViewerWeb extends WebPlugin implements NativeARViewerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
