import { createActions } from 'redux-actions';
import { asyncActions } from '../../utils/constants';

export const { user } = createActions({
   USER: { 
      CREATE_OR_LOAD: asyncActions
   }
});