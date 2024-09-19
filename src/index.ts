import { registerPlugin } from '@capacitor/core';

import type { StartioPlugin } from './definitions';

const Startio = registerPlugin<StartioPlugin>('Startio', {
  web: () => import('./web').then(m => new m.StartioWeb()),
});

export * from './definitions';
export { Startio };
