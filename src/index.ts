import { registerPlugin } from '@capacitor/core';

import type { NativeARViewerPlugin } from './definitions';

const NativeARViewer = registerPlugin<NativeARViewerPlugin>('NativeARViewer', {
  web: () => import('./web').then((m) => new m.NativeARViewerWeb()),
});

export * from './definitions';
export { NativeARViewer };
