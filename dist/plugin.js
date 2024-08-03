var capacitorCapacitorStartIO = (function (exports, core) {
    'use strict';

    const CapacitorStartIO = core.registerPlugin('CapacitorStartIO', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.CapacitorStartIOWeb()),
    });

    class CapacitorStartIOWeb extends core.WebPlugin {
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

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        CapacitorStartIOWeb: CapacitorStartIOWeb
    });

    exports.CapacitorStartIO = CapacitorStartIO;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
