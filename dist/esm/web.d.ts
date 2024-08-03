import { WebPlugin } from '@capacitor/core';
import type * as Definitions from './definitions';
export declare class CapacitorStartIOWeb extends WebPlugin implements Definitions.CapacitorStartIOPlugin {
    initialize(): Promise<void>;
    loadInterstitial(): Promise<Definitions.GetResultString>;
    showInterstitial(): Promise<Definitions.GetResultString>;
}
