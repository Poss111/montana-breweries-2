import { StompConfig, StompService } from '@stomp/ng2-stompjs';

import { WebSocketConfig } from '../websocket.config';

export const stompConfig: StompConfig = {
    url: WebSocketConfig.uri,

    headers: {

    },
    heartbeat_in: 0,

    heartbeat_out: 20000,

    reconnect_delay: 5000,

    debug: false
};