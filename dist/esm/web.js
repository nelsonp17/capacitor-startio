import { WebPlugin } from '@capacitor/core';
export class CapacitorStartIOWeb extends WebPlugin {
    async initialize() { }
    async loadInterstitial() {
        return {
            result: "",
        };
    }
    async showInterstitial() {
        return {
            result: "",
        };
    }
}
//# sourceMappingURL=web.js.map