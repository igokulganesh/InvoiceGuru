import { configureStore } from "@reduxjs/toolkit";
import dataSlice from "./slice";

const store = configureStore({
  reducer: {
    common: dataSlice,
  },
});

export default store;
