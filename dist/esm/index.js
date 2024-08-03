import { registerPlugin } from '@capacitor/core';
const CapacitorStartIO = registerPlugin('CapacitorStartIO', {
    web: () => import('./web').then(m => new m.CapacitorStartIOWeb()),
});
export * from './definitions';
export { CapacitorStartIO };
//# sourceMappingURL=index.js.map