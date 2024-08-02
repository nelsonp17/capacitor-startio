import { registerPlugin } from '@capacitor/core';

import type { CapacitorStartIOPlugin } from './definitions';

const CapacitorStartIO = registerPlugin<CapacitorStartIOPlugin>('CapacitorStartIO', {
  web: () => import('./web').then(m => new m.CapacitorStartIOWeb()),
});

export * from './definitions';
export { CapacitorStartIO };
