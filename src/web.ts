import { WebPlugin } from '@capacitor/core';

//import type { CapacitorStartIOPlugin } from './definitions';
import type * as Definitions from './definitions';

export class CapacitorStartIOWeb extends WebPlugin implements Definitions.CapacitorStartIOPlugin {
    async initialize(): Promise<void> {}
    async loadInterstitial(): Promise<Definitions.GetResultString> {
        return {
            result: "",
        };
    }
    async showInterstitial(): Promise<Definitions.GetResultString> {
        return {
            result: "",
        };
    }
}
