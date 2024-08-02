import { WebPlugin } from '@capacitor/core';

import type { CapacitorStartIOPlugin } from './definitions';

export class CapacitorStartIOWeb extends WebPlugin implements CapacitorStartIOPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
