!function(e,t){"object"==typeof exports&&"object"==typeof module?module.exports=t():"function"==typeof define&&define.amd?define([],t):"object"==typeof exports?exports.composeApp=t():e.composeApp=t()}(this,(()=>(()=>{var e,t,r={646:(e,t,r)=>{"use strict";var o=r(846),s=r.n(o);let n=null;function i(){const e=this.data;switch(e&&e.action){case"exec":if(!e.sql)throw new Error("exec: Missing query string");return postMessage({id:e.id,results:n.exec(e.sql,e.params)[0]??{values:[]}});case"begin_transaction":return postMessage({id:e.id,results:n.exec("BEGIN TRANSACTION;")});case"end_transaction":return postMessage({id:e.id,results:n.exec("END TRANSACTION;")});case"rollback_transaction":return postMessage({id:e.id,results:n.exec("ROLLBACK TRANSACTION;")});default:throw new Error(`Unsupported action: ${e&&e.action}`)}}function a(e){return postMessage({id:this.data.id,error:e})}if("function"==typeof importScripts){n=null;const e=async function(){let e=await s()({locateFile:e=>"/sql-wasm.wasm"});n=new e.Database}();self.onmessage=t=>e.then(i.bind(t)).catch(a.bind(t))}},83:()=>{},639:()=>{},442:()=>{}},o={};function s(e){var t=o[e];if(void 0!==t)return t.exports;var n=o[e]={id:e,loaded:!1,exports:{}};return r[e](n,n.exports,s),n.loaded=!0,n.exports}return s.m=r,s.x=()=>{var e=s.O(void 0,[846],(()=>s(646)));return s.O(e)},e=[],s.O=(t,r,o,n)=>{if(!r){var i=1/0;for(u=0;u<e.length;u++){for(var[r,o,n]=e[u],a=!0,c=0;c<r.length;c++)(!1&n||i>=n)&&Object.keys(s.O).every((e=>s.O[e](r[c])))?r.splice(c--,1):(a=!1,n<i&&(i=n));if(a){e.splice(u--,1);var p=o();void 0!==p&&(t=p)}}return t}n=n||0;for(var u=e.length;u>0&&e[u-1][2]>n;u--)e[u]=e[u-1];e[u]=[r,o,n]},s.n=e=>{var t=e&&e.__esModule?()=>e.default:()=>e;return s.d(t,{a:t}),t},s.d=(e,t)=>{for(var r in t)s.o(t,r)&&!s.o(e,r)&&Object.defineProperty(e,r,{enumerable:!0,get:t[r]})},s.f={},s.e=e=>Promise.all(Object.keys(s.f).reduce(((t,r)=>(s.f[r](e,t),t)),[])),s.u=e=>e+".js",s.g=function(){if("object"==typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"==typeof window)return window}}(),s.o=(e,t)=>Object.prototype.hasOwnProperty.call(e,t),s.nmd=e=>(e.paths=[],e.children||(e.children=[]),e),(()=>{var e;s.g.importScripts&&(e=s.g.location+"");var t=s.g.document;if(!e&&t&&(t.currentScript&&(e=t.currentScript.src),!e)){var r=t.getElementsByTagName("script");if(r.length)for(var o=r.length-1;o>-1&&!e;)e=r[o--].src}if(!e)throw new Error("Automatic publicPath is not supported in this browser");e=e.replace(/#.*$/,"").replace(/\?.*$/,"").replace(/\/[^\/]+$/,"/"),s.p=e})(),(()=>{var e={792:1};s.f.i=(t,r)=>{e[t]||importScripts(s.p+s.u(t))};var t=this.webpackChunkcomposeApp=this.webpackChunkcomposeApp||[],r=t.push.bind(t);t.push=t=>{var[o,n,i]=t;for(var a in n)s.o(n,a)&&(s.m[a]=n[a]);for(i&&i(s);o.length;)e[o.pop()]=1;r(t)}})(),t=s.x,s.x=()=>s.e(846).then(t),s.x()})()));
//# sourceMappingURL=792.js.map