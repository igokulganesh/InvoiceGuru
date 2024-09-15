import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  company: "",
};

const dataSlice = createSlice({
  name: "data",
  initialState,
  reducers: {
    setCompany: (state, action) => {
      state.company = action.payload;
    },
    getCompany: (state) => {
      return state.company;
    },
  },
});

export const { getCompany, setCompany } = dataSlice.actions;
export default dataSlice.reducer;
